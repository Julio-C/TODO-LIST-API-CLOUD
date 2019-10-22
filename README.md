# TodoList_Api
É uma API RESTFUL em Cloud simples para gerenciar tarefas.

Version 2.0.0

Esta aplicação esta Amazenada no Heroku.com.
Para a construção da API utilizei o Spring Tools Suite 4 e o Postgres.

Acesse o https://todolistcaseapi.herokuapp.com/swagger-ui.html para acessar a visão da aplicação pelo swagger.
Clique em tarefa-controller e escolha o método que deseja utilizar(get/post/put/delete) e siga os exemplos existentes em cada um deles.


Utilizei o Postman e o Curl, a seguir os endpoints para realização de testes.


EndPoints Curl:
Os testes são realizados através do git bash.


List:		curl -X GET -H 'Accept: application/json' 'https://todolistcaseapi.herokuapp.com/api/todo/list'

Retorno:	 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   403    0   403    0     0    659      0 --:--:-- --:--:-- --:--:--   			
		658[{"id":1,"title":"Insert","detail":"Testando api em Cloud","status":"Pending","date":"21 de outubro"},
		{"id":2,"title":"Update","detail":"Testando api em Cloud","status":"Pending","date":"21 de outubro"},
		{"id":3,"title":"Delete","detail":"Testando api em Cloud","status":"Pending","date":"21 de outubro"},
		{"id":4,"title":"List","detail":"Testando api em Cloud","status":"Pending","date":"21 de outubro"}]



========================================================================================================================================

FindById:	 curl -X GET -H 'Accept: application/json' 'https://todolistcaseapi.herokuapp.com/api/todo/{id}'

Exemplo:	 curl -X GET -H 'Accept: application/json' 'https://todolistcaseapi.herokuapp.com/api/todo/1'

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   100    0   100    0     0    168      0 --:--:-- --:--:-- --:--:--  
		168{"id":1,"title":"Insert","detail":"Testando api em Cloud","status":"Pending","date":"21 de outubro"}



========================================================================================================================================

PUT :	curl -X PUT -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id": {id},"title": "{title}","detail": "{detail}","status": "{status}","date": "{date}"}' 'https://todolistcaseapi.herokuapp.com/api/todo'

Exemplo:	curl -X PUT -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id": 4,"title": "List" ,"detail": "Testando api em Cloud","status": "Completed","date": "21 de outubro"}' 'https://todolistcaseapi.herokuapp.com/api/todo'

Retorno:	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   206    0   100  100   106    154    163 --:--:-- --:--:-- --:--:--   318{"id":4,"title":"List","detail":"Testando 		api em Cloud","status":"Completed","date":"21 de outubro"}


========================================================================================================================================

POST:		curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"title": "{title}","detail": "{detail}","status": "{status}","date": "{date}"}' 'https://todolistcaseapi.herokuapp.com/api/todo'

Exemplo:	curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"title":"Update","detail":"testando api","status":"Completed","date":"20 de outubro 2019"}' 'https://todolistcaseapi.herokuapp.com/api/todo'

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   189    0    98  100    91    128    119 --:--:-- --:--:-- --:--:--   		
		248{"id":5,"title":"Update","detail":"testando api","status":"Completed","date":"20 de outubro 2019"}



========================================================================================================================================

DELETE:		curl -i -X DELETE 'Content-Type: application/json' -H 'Accept: application/json' -d '{"id": {id},"title": "{title}","detail": "{detail}","status": "{status}","date": "{date}"}' 'https://todolistcaseapi.herokuapp.com/api/todo'

Exemplo:	curl -i -X DELETE 'Content-Type: application/json' -H 'Accept: application/json' -d 	
		'{"title":"Update","detail":"testando api","status":"Completed","date":"20 de outubro"}' 	
		'https://todolistcaseapi.herokuapp.com/api/todo'
		
Retorno:	 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100    99    0     0  100    99      0     23  0:00:04  0:00:04 --:--:--     0HTTP/1.1 200
		Content-Length: 0
		Date: Sun, 20 Oct 2019 22:04:04 GMT

====================================================================================================================================================================================================================================

HealthCheck:	curl POST https://todolistcaseapi.herokuapp.com/actuator/health

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  		0     0    0     0    0     0      0      0 --:--:--  0:00:01 --:--:--     0curl: (6) Could not resolve host: POST
		100    15    0    15    0     0     23      0 --:--:-- --:--:-- --:--:--     0{"status":"UP"}


========================================================================================================================================

Metrics:	curl POST https://todolistcaseapi.herokuapp.com/actuator/metrics/{metric}

Exemplo:	curl POST https://todolistcaseapi.herokuapp.com/actuator/metrics/process.start.time

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  		0     0    0     0    0     0      0      0 --:--:--  0:00:01 --:--:--     0curl: (6) Could not resolve host: POST
		100   193    0   193    0     0    276      0 --:--:-- --:--:-- --:--:--   		
		276{"name":"process.start.time","description":"Start time of the process since unix 		
		epoch.","baseUnit":"seconds","measurements":[{"statistic":"VALUE","value":1.571711506265E9}],"availableTags":[]}


========================================================================================================================================
========================================================================================================================================

Endpoits Postman:

POST :		http://todolistcaseapi.herokuapp.com/api/todo

Obs:		O campo ID é preenchido automaticamente.

Exemplo:	{
    			"title": "Insert",
    			"detail": "Testando api em Cloud",
    			"status": "Pending",
   			"date": "21 de outubro"
    		}


========================================================================================================================================

LIST:		https://todolistcaseapi.herokuapp.com/api/todo/list

Obs:		Retorna todas as tarefas da lista.

Exemplo:
		[
  			{
    				"id": 1,
    				"title": "Insert",
    				"detail": "Testando api em Cloud",
    				"status": "Pending",
   				"date": "21 de outubro"
 			},
  			{
   				"id": 3,
    				"title": "Delete",
    				"detail": "Testando api em Cloud",
    				"status": "Pending",
   			 	"date": "21 de outubro"
  			},
  			{
    				"id": 4,
    				"title": "List",
    				"detail": "Testando api em Cloud",
    				"status": "Complete",
    				"date": "21 de outubro"
  			},
		]
	

========================================================================================================================================

FindById:	https://todolistcaseapi.herokuapp.com/api/todo/{id}

Obs:		Retorna apenas o dado do id informado.

Exemplo:	https://todolistcaseapi.herokuapp.com/api/todo/2

Retorno:	{
    			"id": 2,
    			"title": "Delete",
    			"detail": "testando api",
    			"status": "Pending",
    			"date": "20 de outubro"
		}
	
========================================================================================================================================

PUT:		https://todolistcaseapi.herokuapp.com/api/todo

Obs:		Altera é necessario passar todos os dados, inclusive o id.

Exemplo:	{
    			"id": 4,
    			"title": "Delete",
    			"detail": "testando api",
    			"status": "Completed",
    			"date": "20 de outubro"
		}

========================================================================================================================================

DELETE:		https://todolistcaseapi.herokuapp.com/api/todo

Obs:		Preencher todos os campos.

Exemplo:	{
  			"id": 2,
  			"title": "Insert",
  			"detail": "Testando api em Cloud",
  			"status": "Completed",
  			"date": "21 de outubro 2019"
		}


========================================================================================================================================

METRICS:	https://todolistcaseapi.herokuapp.com/actuator/metrics/{metric}

Exemplo:	https://todolistcaseapi.herokuapp.com/actuator/metrics/process.start.time

Retorno: 	{
    			"name": "process.start.time",
    			"description": "Start time of the process since unix epoch.",
    			"baseUnit": "seconds",
    			"measurements": [
       	 		{
            			"statistic": "VALUE",
            			"value": 1.571596411575E9
        		}
			],
    			"availableTags": []
		}

========================================================================================================================================

HealthCheck:	https://todolistcaseapi.herokuapp.com/actuator/health

Retorno:	{
    			"status": "UP"
		}



