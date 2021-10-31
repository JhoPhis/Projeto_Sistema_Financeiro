function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const ul = document.getElementById("tabela");

const url = "http://localhost:8080/listadespesas";

fetch(url)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let despesas = data;
    var result = "<table border=1>";
    for(var i=0; i<despesas.length; i++) {
        result += "<tr>";
        for(var j=0; j<despesas[i].length; j++){
            result += "<td>"+despesas[i][j]+"</td>";
        }
        result += "</tr>";
    }
    result += "</table>";

    return result;
  })
  .catch(function (error) {
    console.log(error);
  });

//window.onload = makeTableHTML