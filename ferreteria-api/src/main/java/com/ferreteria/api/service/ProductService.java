package com.ferreteria.api.service;

import com.ferreteria.api.model.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    private static final String COLLECTION_NAME = "products";

    private final Firestore firestore;

    public ProductService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    public List<Product> findAll() throws ExecutionException, InterruptedException {
        List<Product> products = new ArrayList<>();
        CollectionReference collection = firestore.collection(COLLECTION_NAME);
        collection.get().get().forEach(doc -> {
            Product product = doc.toObject(Product.class);
            product.setId(doc.getId());
            products.add(product);
        });
        return products;
    }

    public Product save(Product product) throws ExecutionException, InterruptedException {
        DocumentReference docRef;
        if (product.getId() == null) {
            docRef = firestore.collection(COLLECTION_NAME).document();
            product.setId(docRef.getId());
        } else {
            docRef = firestore.collection(COLLECTION_NAME).document(product.getId());
        }
        ApiFuture<WriteResult> write = docRef.set(product);
        write.get();
        return product;
    }

    public Product findById(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(id);
        var snapshot = docRef.get().get();
        if (snapshot.exists()) {
            Product product = snapshot.toObject(Product.class);
            product.setId(snapshot.getId());
            return product;
        }
        return null;
    }

    public Product update(String id, Product product) throws ExecutionException, InterruptedException {
        product.setId(id);
        return save(product);
    }

    public boolean delete(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(id);
        var snapshot = docRef.get().get();
        if (snapshot.exists()) {
            docRef.delete().get();
            return true;
        }
        return false;
    }
}
