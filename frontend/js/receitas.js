function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const ul = document.getElementById("tabela");

const url = "http://localhost:8080/receita";

let data = fetch(url)
  .then((resp) => resp.json())
  .then(function (data) {
    //console.log(data);
    return data;
  })
  .catch(function (error) {
    console.log(error);
  });

////////window.onload = makeTableHTML

$(document).ready(function () {
  $.getJSON(url, function (json) {
    var tr;
    for (var i = 0; i < json.length; i++) {
      var dateCreation = new Date(json[i].data).toLocaleString('pt-BR', {hour12: false});
      tr = $("<tr/>");
      tr.append("<td>" + json[i].nome + "</td>");
      tr.append("<td>" + json[i].descricao + "</td>");
      tr.append("<td>" + dateCreation +  "</td>");
      tr.append("<td>" + 'R$ ' + json[i].valor + "</td>");
      tr.append(
        '<td> <button class="btn btn-outline-dark btn-sm">DETALHES</button> </td>'
      );
      $("table").append(tr);
    }
  });
});
