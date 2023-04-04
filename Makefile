all: 
	docker compose up 
clean: 
	docker compose down && rm ./App/Main.class
fclean: clean
		docker rm -f $(docker ps -a -q)
re: clean all