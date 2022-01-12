# EACH 2021 - Redes de Computadores
Repositório para o EP2 da disciplina ACH2026 - Redes de Computadores

## Integrantes
* Integrante 1 - Barbara Ellen Schorsch Finardi (11207769)
* Integrante 2 - Gandhi Daiti Miyahara (11207773)
* Integrante 3 - Lucas Yuji Tengan Ikeda (11208346)
* Integrante 4 - Mikael Gi Sung Shin (10843441)

## Pré-requisitos
* JDK 11 ou maior (testado com a JDK11 OpenJDK) - não é recomendado utilizar a versão mais recente.
* Gradle (incluso no repositório, não é necessário instalá-lo)

## Regras do TypeRace
* Para cada palavra escrita corretamente, o jogador ganha 1 ponto.
* Não há desconto nos pontos, mesmo se o jogador errar a palavra.
* O jogo vai disponibilizar 30 palavras para cada jogador.
* Caso o jogador escreva 10 palavras corretamente, o jogo termina, se não, o jogo terminará depois que algum jogador digitar todas as 30 palavras, e o jogador que escrever mais palavras corretamente vence o jogo.
* Divirta-se!

## Observação
* A partida iniciará somente quando todos os jogadores estiverem prontos, ou seja, depois que todos dispararem o evento (pressionar "Enter"). 

### Rodando
Para rodar o servidor
```sh
gradlew server:run --console=plain
```

Para rodar um cliente 
```sh
gradlew client:run --console=plain
```
