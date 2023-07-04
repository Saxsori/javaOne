IMAGE_NAME_PROD = javaone_prod

IMAGE_NAME_DEV = javaone_dev

CONTAINER_NAME = javaone

dev:
	docker build -t $(IMAGE_NAME_DEV) --target development .
	docker run -it -d --name $(CONTAINER_NAME) -v $(PWD)/src:/JavaOne $(IMAGE_NAME_DEV)
	docker exec -it javaone /bin/sh

run:
	@ docker build -q -t $(IMAGE_NAME_PROD) --target production .
	@ docker run -it --name $(CONTAINER_NAME) $(IMAGE_NAME_PROD)

stop:
	docker stop $(CONTAINER_NAME)

clean: stop
	docker rm $(CONTAINER_NAME)
	docker rmi $(IMAGE_NAME_DEV) $(IMAGE_NAME_PROD)

re : clean all