# cria a sqs
#aws --endpoint-url=http://localhost:4576 sqs create-queue --queue-name create-user-sqs

# lista as filas
#aws --endpoint-url=http://localhost:4576 sqs list-queues

# envia mensagem para a fila
aws --endpoint-url=http://localhost:4576 sqs send-message --queue-url http://localhost:4576/000000000000/create-user-sqs --message-body '{"name": "Paulo Nayron","email": "paulo.nayron@jaya.tech"}'

# consume a fila
#aws --endpoint-url=http://localhost:4576 sqs receive-message --queue-url http://localhost:4566/000000000000/playground-sqs