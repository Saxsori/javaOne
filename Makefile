IMAGE_NAME = javaone

CONTAINER_NAME = javaone

all: build run

build:
	docker build -t $(IMAGE_NAME) .

run:
	docker run -it --name $(CONTAINER_NAME) -v $(PWD)/src:/src $(IMAGE_NAME)

stop:
	docker stop $(CONTAINER_NAME)

clean: stop
	docker rm $(CONTAINER_NAME)
	docker rmi $(IMAGE_NAME)

re : clean all