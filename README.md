## Projeto final CTT-Java.API

### Detalhes do sistema

Queremos criar um sistema para centralizar informações sobre vacinações contra a COVID-19 nos municípios brasileiros.

O sistema precisa receber informações sobre número de vacinados num município numa determinada data. Também deverá ser
informada qual vacina foi utilizada.

Uma análise inicial nos mostra que precisaremos cadastrar:

#### Estados

```json
{
  "id": 1,
  "nome": "São Paulo",
  "sigla": "SP"
}
```

#### Municípios

```json
{
  "id": 1,
  "nome": "Campinas",
  "estado": "<Estado>"
}
```

#### Vacinas

```json
{
  "id": 1,
  "nome": "São Paulo",
  "origem": "Brasil"
}
```

Dessa forma poderemos criar um registro contendo:

- Número de pacientes vacinados por data, incluindo a vacina, num determinado município

```json
{
  "id": 1,
  "municipio": "<Municipio>",
  "data": "2021-02-04",
  "total": 236,
  "vacina": "<Vacina>"
}
```

### Dados para relatório (extras)

Uma vez que se tenha uma massa de dados interessante, desejamos extrair informações para a montagem de relatórios.
Alguns exemplos abaixo:

- Número de pessoas vacinadas por município num determinado período
- Número total de cada tipo de vacina num determinado período
- Total de vacinados por município num determinado período
- Total de vacinados por estado num determinado período
- Total de vacinados por tipo de vacina num determinado período
