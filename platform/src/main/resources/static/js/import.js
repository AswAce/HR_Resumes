 
  let allCandidates=[]
  fetch(
  "https://spreadsheets.google.com/feeds/cells/1xSrts2BF5-ESPmHJ66xaSK2-iYFDfiVloBfUVL6hnlc/1/public/full?alt=json"
)
  .then((response) => response.json())
  .then((data) =>getCandidates(data)
  );
 

function getCandidates(data){
  
    let all = data["feed"]["entry"];
    let scoreCol;
    let rows;
    let emailCol;
    for (let field of all) {
      const cell = field["gs$cell"];
      if (cell["inputValue"] === "Score") {
        scoreCol = cell["col"];
      }
      rows = cell["row"];

      if (cell["inputValue"] === "Enter your email:") {
        emailCol = cell["col"];
      }
    }
    var candidate = Object.create({});
    for (let field = 0; field < all.length; field++) {
       
      
      const element = all[field];
      let nextElement;
      let nextCell;
     
      if (field + 1 < all.length) {
        nextElement = all[field + 1];
        nextCell = nextElement["gs$cell"];
      }

      const cell = element["gs$cell"];
     
      if (cell["col"] == emailCol && cell["row"] != 1) {
     
        candidate.email = cell["inputValue"];
      }
      if (cell["col"] === scoreCol && cell["row"] != 1) {
        candidate.score = cell["$t"];
      }
      if (
        cell["row"] != 1 &&
        (nextCell == undefined || cell["row"] != nextCell["row"])
      ) {
       
        let candidate2 =Object.create({})
        candidate2.email=candidate['email']
        candidate2.score=candidate['score']
 
        allCandidates.push(candidate2);
      }
    }
  }
  (async () => {
 await  fetch('http://localhost:8080', {
    method: 'POST', // or 'PUT'
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(allCandidates),
  })
  .then(response => response.json())
  .then(data => {
    console.log('Success:', allCandidates);
  })
  .catch((error) => {
    console.error('Error:', error);
  });
  })();
   console.log( allCandidates);
