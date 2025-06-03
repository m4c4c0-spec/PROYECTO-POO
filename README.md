# PROYECTO-POO
FERRETERIA-PFEIFERS

## Backend API

El directorio `ferreteria-api` contiene un proyecto Spring Boot con un CRUD básico de productos. Para compilarlo y ejecutarlo utiliza Maven:

```bash
cd ferreteria-api
./mvnw spring-boot:run
```

Esto inicia el servidor en `http://localhost:8080`. El endpoint principal es `/api/products`.

## Frontend React

El directorio `ferreteria-frontend` contiene una aplicación React creada con Vite. Para instalar las dependencias y ejecutarla:

```bash
cd ferreteria-frontend
npm install
npm run dev
```

La aplicación se abrirá en `http://localhost:3000` y consumirá el backend desde `http://localhost:8080`.
