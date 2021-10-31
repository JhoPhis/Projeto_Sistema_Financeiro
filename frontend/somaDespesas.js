function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const ul = document.getElementById("somaDespesas");

const url = "http://localhost:8080/somadespesas";

fetch(url)
  .then((resp) => resp.json())
  .then(function (data) {
    console.log(data);
    let somaDespesas = data;
    console.log(somaDespesas);
    somaDespesas.split(",");
    console.log(somaDespesas);

    let li = createNode("li");
    let img = createNode("img");
    let span = createNode("span");
    span.innerHTML = `${somaDespesas}`;
    append(li, img);
    append(li, span);
    append(ul, li);
  })
  .catch(function (error) {
    console.log(error);
  });

// async function getSomaDespesas() {
//   const response = await fetch("http://localhost:8080/somadespesas");
//   var despesas = await response.json();
//   console.log(despesas);
//   let authors = despesas.results;
// }

// function jsonToTable(json) {
//   var parsejson = JSON.parse(json);
//   var columns = [];
//   var tablethread = "<thead><tr>";
//   for (x in parsejson[0]) {
//     columns.push(x);
//     tablethread += "<th>" + x + "</th>";
//   }
//   tablethread += "</tr></thead>";
//   document.getElementById("tableID").innerHTML = tablethread;
//   var table_rows = "<tbody>";
//   for (var i = 0; i < parsejson.length; i++) {
//     var x = parsejson[i];
//     var json2 = x;
//     var row = "<tr>";
//     for (d in x) {
//       var sty = x[d];
//       if (sty != null) {
//         var st = sty.toString();
//         var reps = "<\\";
//         row += "<td><p>" + st.split("<").join("&lt;") + "</p></td>";
//       } else {
//         row += "<td><p>null</p></td>";
//       }
//     }
//     row += "</tr>";
//     table_rows += row;
//   }
//   table_rows += "</tbody>";
//   document.getElementById("tableID").innerHTML += table_rows;
// }
