IMAGE_NAME = javaone

CONTAINER_NAME = javaone

# all: build run

dev:
	docker build --build-arg JRUN=false -t $(IMAGE_NAME) .
	docker run -it -d --name $(CONTAINER_NAME) -v $(PWD)/src:/JavaOne $(IMAGE_NAME)
	docker exec -it javaone /bin/sh

run:
	@ docker build -q --build-arg JRUN=true -t $(IMAGE_NAME) .
	@ docker run -it --name $(CONTAINER_NAME) $(IMAGE_NAME)

stop:
	docker stop $(CONTAINER_NAME)

clean: stop
	docker rm $(CONTAINER_NAME)
	docker rmi $(IMAGE_NAME)

re : clean all