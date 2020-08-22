build_app:
	mvn package -DskipTests=true
run:
	make build_app && docker build . -t ebs_jwt_service && docker run --name ebs_jwt_service --net=ebs_app_net -d -t ebs_jwt_service
stop:
	docker stop ebs_jwt_service