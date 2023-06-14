IMAGE_NAME = javaone

CONTAINER_NAME = javaone

all: build run

build:
	docker build -t $(IMAGE_NAME) .

run:
	docker run -it --name $(CONTAINER_NAME) $(IMAGE_NAME)

clean:
	docker rm $(CONTAINER_NAME)
	docker rmi $(IMAGE_NAME)

re : clean all