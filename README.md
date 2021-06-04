 ## API PRODUTOS

Tecnologias: 
- Spring-Boot;
- JPA;
- JPQL;
- MySQL;

Como subir a api:
1) Utilize o MySQLWorkbench para criar um banco chamado 'apirest'
2) Configurar no arquivo 'application.properties' o banco de dados:
-   -spring.datasource.username='nome do usuario root'
-   -spring.datasource.password='senha do usuario root'

3) Rodar o projeto

ENDPOINTS:

### [GET]:
- /produtos - Seleciona todos os produtos
- /produtos/{id} - Seleciona produto por id
- /produtos/{nome} - Seleciona produto por nome
- /produtosPorNome/{nome} - Seleciona produtos por nome iniciando com..
- /lojas - Seleciona todas as lojas
- /lojas/{id} - Seleciona lojas por id1. - 

------------



### [POST]:
- /produtos - Insere produto
- /lojas - Insere loja


------------



### [DELETE]:
- /produtos/{id} - Exclui produto por id
- /lojas/{id} - Exclui loja por id


------------


### [UPDATE]:
- /produtos/{id} - Atualiza produto por id
- /lojas/{id} - Atualiza loja por id

