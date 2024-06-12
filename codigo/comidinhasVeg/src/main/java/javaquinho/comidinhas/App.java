
// IMPORT DE CLIENTE NO POSTMAN: 

/* 
{
	"info": {
		"_postman_id": "e6672f1d-3ea2-4470-8fee-0e00578f25c1",
		"name": "Requisições do Cliente",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "34537890",
		"_collection_link": "https://aa5555-4919.postman.co/workspace/9d3ba132-78d7-4b10-b2ce-d12398d48bc1/collection/34537890-e6672f1d-3ea2-4470-8fee-0e00578f25c1?action=share&source=collection_link&creator=34537890"
	},
	"item": [
		{
			"name": "Listar todos clientes",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/clientes",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes"
					]
				}
			},
			"response": []
		},
		{
			"name": "Buscar cliente por ID",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/clientes/{id}",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes",
						"{id}"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Criar cliente",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nome\": \"Carlos Pereira\",\n  \"telefone\": \"11987654323\",\n  \"cpf\": \"12312312399\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/clientes",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes"
					]
				}
			},
			"response": []
		},
		{
			"name": "Atualizar cliente existente",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"nome\": \"Carlos Pereira Atualizado\",\n  \"telefone\": \"11987654324\",\n  \"cpf\": \"12312312399\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/clientes/{id}",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes",
						"{id}"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Excluir cliente",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/clientes/{id}",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes",
						"{id}"
					],
					"variable": [
						{
							"key": "id",
							"value": "1"
						}
					]
				}
			},
			"response": []
		}
	]
}
*/