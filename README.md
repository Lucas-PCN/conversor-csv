# Projeto Conversor CSV

<p>Projeto entregue durante o curso de desenvolvimento Web ministrado pela <a href="https://www.betrybe.com" targe="_blank" rel="nofollow">Trybe</a>.</p>

<p>Obtive a aprovação no projeto completando 100% dos requisitos obrigatórios e opcionais. Efetivando, assim, a conclusão do Bloco 3 (Manipulação de textos e arquivos) referente a Aceleração em Java.</p>

## Descrição

  O objetivo deste projeto, foi elaborar um programa em Java capaz de converter os arquivos gerados pela página web (**arquivos de entrada**) para o formato requerido pelo subsistema e enviá-los para um **arquivo de saída**.

   Os arquivos CSV gerados pela página web estão disponíveis na pasta `entradas`, estando separados por estado. 
   
   - Por exemplo: `sp.csv`, `mg.csv`, `ba.csv`...
   
   Para cada arquivo contido na pasta `entradas`, foi criado um arquivo correspondente com o mesmo nome na pasta `saidas`.
   
#### :stop_sign:	Foram garantidas as seguintes condições a respeito dos arquivos de **entrada**:
  - Toda data de nascimento está em formato brasileiro: `dd/mm/aaaa`
  - Todo email é válido
  - Todo CPF é válido e composto por exatamente 11 dígitos decimais (sem ponto nem hífen)

#### :stop_sign:	A formatação requerida para os arquivos de saída foi a seguinte:
  - O cabeçalho deveria ser o mesmo dos arquivos de entrada.
  - Os nomes completos dos inscritos deveriam ser padronizados todos em letras maiúsculas (acentos gráficos devem ser mantidos).
  - As datas de nascimento deveriam estar no formato ISO-8601: `aaaa-mm-dd`.
  - Os números de CPF deveriam estar corretamente formatados com ponto e hífen. Exemplo: `123.456.789-09`.

  As linhas dos arquivos de saída foram dispostas na mesma ordem que as dos arquivos de entrada.

## Rodando o projeto localmente
  1. Clone o repositório
   
     `git@github.com:Lucas-PCN/conversor-csv.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd conversor-csv`

  3. Instale as dependências:
    
     `mvn install`

## Demonstração

###	Exemplo
  Para o arquivo de entrada a seguir: `entradas/sp.csv`
  ```
    Nome completo,Data de nascimento,Email,CPF
    IRANI TAPEREBÁ,29/06/2001,tapereba@gmail.com,81627775471
    catarina mafra,28/05/1991,cmafra@gmail.com,75157671466
    bento naves,25/12/1993,b.naves@aol.com,88826690685
    Lurdes Neves,08/04/1985,lurdes.neves85@verizon.net,92277079138
  ```

  Foi produzido o seguinte arquivo de saída: `saidas/sp.csv`
  ```
    Nome completo,Data de nascimento,Email,CPF
    IRANI TAPEREBÁ,2001-06-29,tapereba@gmail.com,816.277.754-71
    CATARINA MAFRA,1991-05-28,cmafra@gmail.com,751.576.714-66
    BENTO NAVES,1993-12-25,b.naves@aol.com,888.266.906-85
    LURDES NEVES,1985-04-08,lurdes.neves85@verizon.net,922.770.791-38
  ```
---

Projeto desenvolvido por Lucas Castanheira, para fins didáticos. 2023
