# EACH 2021 - Redes de Computadores
Repositório para o EP2 da disciplina ACH2026 - Redes de Computadores

## Integrantes
* Integrante 1 - Barbara Ellen Schorsch Finardi
* Integrante 2 - Gandhi Daiti Miyahara
* Integrante 3 - Lucas Yuji Tengan Ikeda
* Integrante 4 - Mikael Gi Sung Shin

## Pré-requisitos
* JDK 11 ou maior (testado com a JDK11 OpenJDK)
* Gradle (incluso no repositório, não é necessário instalá-lo)

## Regras do TypeRace
- Para cada palavra escrita corretamente, o jogador ganha 1 ponto.
- Nenhum ponto é descontado, mesmo se o jogador errar a palavra.
- O jogo vai disponibilizar 20 palavras para o jogador escrever corretamente.
- O jogador que escrever mais palavras corretamente vence o jogo.
- Divirta-se!

### Rodando
Para rodar o servidor
```sh
gradlew server:run --console=plain
```

Para rodar um cliente 
```sh
gradlew client:run --console=plain
```
