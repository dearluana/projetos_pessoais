<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora de Média</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        button {
            margin-top: 10px;
            padding: 8px;
            font-size: 16px;
        }
    </style>
</head>
<body>

<h2>Notas dos Alunos</h2>

<table id="notasTable">
    <tr>
        <th>Aluno</th>
        <th>1ª Chamada</th>
        <th>2ª Chamada</th>
    </tr>
    <tr>
        <td>Ana Maria</td>
        <td><input type="text" id="anaMaria1"></td>
        <td><input type="text" id="anaMaria2"></td>
    </tr>
    <tr>
        <td>João</td>
        <td><input type="text" id="joao1"></td>
        <td><input type="text" id="joao2"></td>
    </tr>
    <tr>
        <td>Rui Manuel</td>
        <td><input type="text" id="ruiManuel1"></td>
        <td><input type="text" id="ruiManuel2"></td>
    </tr>
</table>

<button onclick="calcularMedia()">Calcular</button>
<button onclick="limparCampos()">Limpar</button>

<script>
    function calcularMedia() {
        try {
            const anaMariaNota1 = parseFloat(document.getElementById('anaMaria1').value);
            const anaMariaNota2 = parseFloat(document.getElementById('anaMaria2').value);
            
            const joaoNota1 = parseFloat(document.getElementById('joao1').value);
            const joaoNota2 = parseFloat(document.getElementById('joao2').value);
            
            const ruiManuelNota1 = parseFloat(document.getElementById('ruiManuel1').value);
            const ruiManuelNota2 = parseFloat(document.getElementById('ruiManuel2').value);

            const mediaAnaMaria = (anaMariaNota1 + anaMariaNota2) / 2;
            const mediaJoao = (joaoNota1 + joaoNota2) / 2;
            const mediaRuiManuel = (ruiManuelNota1 + ruiManuelNota2) / 2;

            alert(`Média de Ana Maria: ${mediaAnaMaria.toFixed(2)}\nMédia de João: ${mediaJoao.toFixed(2)}\nMédia de Rui Manuel: ${mediaRuiManuel.toFixed(2)}`);
        } catch (error) {
            alert('Erro ao calcular a média. Certifique-se de inserir valores numéricos.');
        }
    }

    function limparCampos() {
        const inputs = document.querySelectorAll('input[type="text"]');
        inputs.forEach(input => input.value = '');
    }
</script>

</body>
</html>
