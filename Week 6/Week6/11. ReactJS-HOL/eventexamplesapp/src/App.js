import { useState } from "react";

function App() {
  const [count, setCount] = useState(1);
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("");

  function increment() {
    setCount(count + 1);
  }

  function sayHello() {
    alert("Hello Member!");
  }

  function increase() {
    increment();
    sayHello();
  }

  function decrement() {
    setCount(count - 1);
  }

  function welcome(msg) {
    alert(msg);
  }

  function clicked() {
    alert("I was clicked");
  }

  function handleSubmit(e) {
    e.preventDefault();

    const rates = {
      EUR: 80,
      USD: 86,
      AUD: 56,
      AED: 23,
      IDR: 0.0053,
      GBP: 100,
      SGD: 67,
      RMB: 12,
    };

    const cur = currency.toUpperCase();

    if (rates[cur]) {
      const converted = amount * rates[cur];
      alert(`Converting to ${cur}\nAmount is ${converted}`);
    } else {
      alert("Invalid Currency");
    }
  }

  return (
    <div style={{ padding: "20px" }}>
      <h2>{count}</h2>

      <button onClick={increase}>Increment</button>
      <br />
      <br />

      <button onClick={decrement}>Decrement</button>
      <br />
      <br />

      <button onClick={() => welcome("Welcome")}>Say Welcome</button>
      <br />
      <br />

      <button onClick={clicked}>Click on me</button>

      <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>

      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>Amount:</td>
              <td>
                <input
                  type="number"
                  value={amount}
                  onChange={(e) => setAmount(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>Currency:</td>
              <td>
                <input
                  type="text"
                  placeholder="EUR, USD, AED..."
                  value={currency}
                  onChange={(e) => setCurrency(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td></td>
              <td>
                <button type="submit">Submit</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default App;