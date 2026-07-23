import "./App.css";

function App() {

  const office = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: "https://images.unsplash.com/photo-1497366811353-6870744d04b2"
    },
    {
      Name: "Regus",
      Rent: 75000,
      Address: "Hyderabad",
      Image: "https://images.unsplash.com/photo-1497366754035-f200968a6e72"
    },
    {
      Name: "WeWork",
      Rent: 65000,
      Address: "Bangalore",
      Image: "https://images.unsplash.com/photo-1497366412874-3415097a27e7"
    }
  ];

  return (
    <div>
      <h1>Office Space, at Affordable Range</h1>

      {office.map((item, index) => (
        <div key={index}>
          <img
            src={item.Image}
            alt="Office"
            width="250"
            height="200"
          />

          <h2>Name: {item.Name}</h2>

          <h3
            style={{
              color: item.Rent < 60000 ? "red" : "green"
            }}
          >
            Rent: Rs. {item.Rent}
          </h3>

          <h3>Address: {item.Address}</h3>

          <hr />
        </div>
      ))}
    </div>
  );
}

export default App;