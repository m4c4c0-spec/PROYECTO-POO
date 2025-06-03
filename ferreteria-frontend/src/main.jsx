import React from 'react'
import ReactDOM from 'react-dom/client'

function App() {
  const [products, setProducts] = React.useState([])

  React.useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(res => res.json())
      .then(setProducts)
      .catch(console.error)
  }, [])

  return (
    <div>
      <h1>Productos</h1>
      <ul>
        {products.map(p => (
          <li key={p.id}>{p.name} - ${p.price}</li>
        ))}
      </ul>
    </div>
  )
}

ReactDOM.createRoot(document.getElementById('root')).render(<App />)
