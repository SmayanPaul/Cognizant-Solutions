function App() {
  const books = [
    { id: 101, bname: "Master React", price: 670 },
    { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
    { id: 103, bname: "Mongo Essentials", price: 450 },
  ];

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Stephen Biz",
      content: "Welcome to learning React!",
    },
    {
      id: 2,
      title: "Installation",
      author: "Schwedenier",
      content: "You can install React from npm.",
    },
  ];

  const courses = [
    { id: 1, name: "Angular", date: "4/5/2021" },
    { id: 2, name: "React", date: "6/3/2021" },
  ];

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "space-around",
        padding: "30px",
      }}
    >
      <div style={{ borderRight: "3px solid green", paddingRight: "20px" }}>
        <h1>Course Details</h1>
        {courses.map((course) => (
          <div key={course.id}>
            <h2>{course.name}</h2>
            <p>{course.date}</p>
          </div>
        ))}
      </div>

      <div style={{ borderRight: "3px solid green", paddingRight: "20px" }}>
        <h1>Book Details</h1>
        {books.map((book) => (
          <div key={book.id}>
            <h3>{book.bname}</h3>
            <h4>{book.price}</h4>
          </div>
        ))}
      </div>

      <div>
        <h1>Blog Details</h1>
        {blogs.map((blog) => (
          <div key={blog.id}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.content}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;