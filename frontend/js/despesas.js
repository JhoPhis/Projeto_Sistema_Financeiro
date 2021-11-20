function createNode(element) {
  return document.createElement(element);
}
function append(parent, el) {
  return parent.appendChild(el);
}

const url = "http://localhost:8080/despesa";

let data = fetch(url)
  .then((resp) => resp.json())
  .then(function (data) {
    //console.log(data);
    return data;
  })
  .catch(function (error) {
    console.log(error);
  });

function renderTable() {
  $(document).ready(function () {
    $.getJSON(url, function (json) {
      var tr;
      for (var i = 0; i < json.length; i++) {
        var dateCreation = new Date(json[i].data).toLocaleString("pt-BR", {
          hour12: false,
        });
        var dateExpire = new Date(json[i].vencimento).toLocaleString("pt-BR", {
          hour12: false,
        });
        tr = $("<tr/>");
        tr.append("<td>" + json[i].nome + "</td>");
        tr.append("<td>" + json[i].descricao + "</td>");
        tr.append("<td>" + dateCreation + "</td>");
        tr.append("<td>" + "R$ " + json[i].valor + "</td>");
        tr.append("<td>" + dateExpire + "</td>");
        tr.append(
          '<td> <button class="btn btn-outline-dark btn-sm">DETALHES</button> </td>'
        );
        $("#table_body").append(tr);
      }
    });
  });
}

function buscar(data) {
  $("#table_body").empty();
  var startDate = document.getElementById("dataInicial");
  var endDate = document.getElementById("dataFinal");

  console.log(startDate.value.toLocaleString());
  console.log(endDate.value.toLocaleString());

  $(document).ready(function () {
    $.getJSON(url, function (json) {
      var tr;
      for (var i = 0; i < json.length; i++) {
        var dateCreation = new Date(json[i].data).toLocaleString("pt-BR", {
          hour12: false,
        });
        var dateExpire = new Date(json[i].vencimento).toLocaleString("pt-BR", {
          hour12: false,
        });

        var dataJson = new Date(json[i].data).toISOString().split("T")[0];
        var dataIni = new Date(startDate.value).toISOString().split("T")[0];
        var dataFin = new Date(endDate.value).toISOString().split("T")[0];

        if (dataJson > dataIni && dataJson < dataFin) {
          console.log("entrouif");
          tr = $("<tr/>");
          tr.append("<td>" + json[i].nome + "</td>");
          tr.append("<td>" + json[i].descricao + "</td>");
          tr.append("<td>" + dateCreation + "</td>");
          tr.append("<td>" + "R$ " + json[i].valor + "</td>");
          tr.append("<td>" + dateExpire + "</td>");
          tr.append(
            '<td> <button class="btn btn-outline-dark btn-sm">DETALHES</button> </td>'
          );
          $("#table_body").append(tr);
        }
      }
    });
  });
}

window.onload = renderTable;
