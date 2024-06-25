# Sistema de Gestão de Funcionários

Este projeto Java, para fins de processo seletivo, é um sistema de gerenciamento de funcionários simples que executa várias operações nos dados dos funcionários. Inclui classes para `Person` e `Employee`, e uma classe `Main` que trata das principais operações, como adição de funcionários, remoção de funcionários, atualização de salários e muito mais.

## Características
1. **Classe Pessoal**
 - Atributos: `name` (String), `dateOfBirth` (LocalDate)

2. **Classe de Funcionário (estende Pessoa)**
 - Atributos: `salary` (BigDecimal), `role` (String)

3. **Operações da Classe Principal**
 - Adicione uma lista de funcionários.
 - Remover um funcionário pelo nome.
 - Imprima todas as informações dos funcionários com formatação específica para datas e valores numéricos.
 - Aplicar um aumento salarial a todos os funcionários.
 - Agrupar funcionários por suas funções.
 - Imprimir funcionários agrupados por suas funções.
 - Imprimir funcionários com aniversários em outubro e dezembro.
 - Imprima o funcionário mais velho com sua idade.
 - Imprimir funcionários em ordem alfabética.
 - Calcule e imprima o total dos salários de todos os funcionários.
 - Imprimir quantos salários mínimos cada funcionário ganha, considerando um salário mínimo de R$ 1.212,00.

## Começando

### Pré-requisitos
- Kit de Desenvolvimento Java (JDK) 8 ou superior

### Instalação
1. Clone o repositório:
 ```sh
 git clone https://github.com/Debora1Allen/Employee-Table
 ```
2. Navegue até o diretório do projeto:
 ```sh
 cd processo-seletivo-teste-funcionário
 ```

### Executando o aplicativo
1. Compile os arquivos Java:
 ```sh
 javac Main.java
 ```
2. Execute o aplicativo:
 ```sh
 java main
 ```

## Classes e Métodos

### Classe Pessoal
- **Atributos**:
 - `name`: Nome da pessoa.
 - `dateOfBirth`: Data de nascimento da pessoa.

### Classe de Funcionário
- **Atributos**:
 - `salary`: Salário do funcionário.
 - `role`: Função ou cargo do funcionário.

### Classe Principal
A classe `Main` contém o método principal e executa várias operações conforme especificado. As etapas detalhadas são as seguintes:

1. **Adicionando funcionários**: uma lista de funcionários é criada e preenchida.
2. **Remoção de Funcionário**: O funcionário chamado "João" é removido da lista.
3. **Impressão de informações do funcionário**: os detalhes do funcionário são impressos com formatação específica.
4. **Aumento Salarial**: Todos os funcionários recebem um aumento salarial de 10%.
5. **Agrupamento por função**: os funcionários são agrupados por suas funções e impressos.
6. **Aniversariantes de outubro e dezembro**: São impressos os funcionários aniversariantes nesses meses.
7. **Funcionário Mais Antigo**: O funcionário mais antigo é identificado e impresso.
8. **Ordem Alfabética**: Os funcionários são impressos em ordem alfabética.
9. **Total de Salários**: A soma total de todos os salários é calculada e impressa.
10. **Cálculo do Salário Mínimo**: É calculado e impresso o número de salários mínimos que cada funcionário recebe.


## Licença
Este projeto está licenciado sob a licença MIT.

---

