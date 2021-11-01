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
        ehDespesa: true,
        vencimento: mvencimento.replace("T", " "),
      };
    } else {
      obj = {
        nome: mnome,
        descricao: mdescricao,
        data: mdata.replace("T", " "),
        valor: mvalor,
        ehDespesa: false,
      };
    }
    console.log(obj);
    const req = await fetch("http://localhost:8080/notafiscal", {
      method: "POST",
      headers: { "Content-Type": "application/json" },

      body: JSON.stringify({
        nome: obj.nome,
        descricao: obj.descricao,
        data: obj.data,
        valor: obj.valor,
        ehDespesa: obj.ehDespesa,
      }),
    });

    const res = await req.json();
    alert("Inserido com sucesso!");
    console.log(res);
    window.location.reload();
  } catch (err) {
    console.error(`ERROR: ${err}`);
  }


}