IMAGE_NAME = java-javone

.PHONY: all build run clean

all: build run

build:
	docker build -t $(IMAGE_NAME) .

run:
	docker run -it $(IMAGE_NAME)

clean:
	docker rmi $(IMAGE_NAME)