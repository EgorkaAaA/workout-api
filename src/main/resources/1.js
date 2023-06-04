console.log('Start')
const response = fetch("http://example.com/movies.json");
const jsonData = response.json();
console.log(jsonData);