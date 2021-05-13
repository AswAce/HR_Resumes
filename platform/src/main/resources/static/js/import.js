run()

async function run(){
const englishTestPath= "https://spreadsheets.google.com/feeds/cells/1xSrts2BF5-ESPmHJ66xaSK2-iYFDfiVloBfUVL6hnlc/1/public/full?alt=json"



 const allEnglishTest = document.getElementById('englishTest')
 allEnglishTest.innerHTML =""

  let c=[]
 let zzzzz= await getTestResults(englishTestPath,c)


  async function getTestResults(testPath,allCandidates){
  let allResults=''
  const responce =await fetch(
                   testPath
                  )
                    .then((response) => response.json())
                    .then((data) =>{getCandidates(data)
                    }
                    );
 async function getCandidates(data){

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
        candidate2.html=`
                                <div> <h4> ${candidate2.email}</h4> </div>
                                <div> <h4> ${candidate2.score}</h4> </div>
                                `;
        allCandidates.push(candidate2);
      }
    }

  }
   allCandidates.forEach(myFunction)
   async  function myFunction(value) {
        allResults= allResults + value.html + " ";
    }
    return  allResults;
  }








allEnglishTest.innerHTML =zzzzz
 console.log(zzzzz)

console.log(c)
}