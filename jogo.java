<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jogo de Adivinhação</title>
</head>
<body>
    <h1>Jogo de Adivinhação</h1>
    <p>Digite um número entre 1 e 100:</p>
    <input type="number" id="guess" min="1" max="100">
    <button id="submit">Adivinhar</button>
    <button id="restart" style="display: none;">Jogar novamente</button>
    <div id="message"></div>

    <script>
        let numeroAleatorio = Math.floor(Math.random() * 100) + 1;
        const guessInput = document.getElementById('guess');
        const messageDiv = document.getElementById('message');
        const submitBtn = document.getElementById('submit');
        const restartBtn = document.getElementById('restart');

        function verificarPalpite() {
            const palpite = parseInt(guessInput.value, 10);

            if (isNaN(palpite)) {
                messageDiv.textContent = 'Digite um número válido!';
                return;
            }
            if (palpite < 1 || palpite > 100) {
                messageDiv.textContent = 'O número deve estar entre 1 e 100!';
                return;
            }
            if (palpite === numeroAleatorio) {
                messageDiv.textContent = 'Parabéns! Você acertou!';
                submitBtn.style.display = 'none';
                restartBtn.style.display = 'inline';
                return;
            }
            messageDiv.textContent = palpite < numeroAleatorio ? 'Tente um número maior!' : 'Tente um número menor!';
        }

        function reiniciarJogo() {
            numeroAleatorio = Math.floor(Math.random() * 100) + 1;
            guessInput.value = '';
            messageDiv.textContent = '';
            submitBtn.style.display = 'inline';
            restartBtn.style.display = 'none';
        }

        submitBtn.addEventListener('click', verificarPalpite);
        restartBtn.addEventListener('click', reiniciarJogo);
    </script>
</body>
</html>
