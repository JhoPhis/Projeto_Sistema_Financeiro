function hide() {
  var checkBox = document.getElementById("ehDespesa");
  var text = document.getElementById("vencimento");

  if (checkBox.checked == true) {
    text.style.display = "block";
  } else {
    text.style.display = "none";
  }
}

async function post(obj) {
  try {
    var mnome = document.getElementById("nomeForm").value;
    var mdescricao = document.getElementById("descForm").value;
    var mdata = document.getElementById("dataForm").value;
    var mvalor = document.getElementById("valorForm").value;
    var mvencimento = document.getElementById("vencimentoForm").value;
    var chbox = document.getElementById("ehDespesa");

    if (chbox.checked == true) {
      obj = {
        nome: mnome,
        descricao: mdescricao,
        data: mdata.replace("T", " "),
        valor: mvalor,
        vencimento: mvencimento.replace("T", " "),
      };
      const req = await fetch("http://localhost:8080/despesa", {
        method: "POST",
        headers: { "Content-Type": "application/json" },

        body: JSON.stringify({
          nome: obj.nome,
          descricao: obj.descricao,
          data: obj.data,
          valor: obj.valor,
          vencimento: obj.vencimento,
        }),
      });

      const res = await req.json();
      alert("Inserido com sucesso!");
      console.log(res);
      window.location.href = "./despesas.html"
    } else {
      obj = {
        nome: mnome,
        descricao: mdescricao,
        data: mdata.replace("T", " "),
        valor: mvalor,
      };
      const req = await fetch("http://localhost:8080/receita", {
        method: "POST",
        headers: { "Content-Type": "application/json" },

        body: JSON.stringify({
          nome: obj.nome,
          descricao: obj.descricao,
          data: obj.data,
          valor: obj.valor,
        }),
      });

      const res = await req.json();
      alert("Inserido com sucesso!");
      console.log(res);
      window.location.href = "./receitas.html"
    }
    console.log(obj);
  } catch (err) {
    console.error(`ERROR: ${err}`);
  }
}
