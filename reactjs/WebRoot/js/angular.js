var angularModule=angular.module("angularModule",[]);
angularModule.controller("angularController",function($scope,$http){
	$http({
		method:"post",
		url:"userServlet"
	}).success(function(data) {
		$scope.userInfos=data;
      }).error(function(data,status,headers,config){  
        alert("错误");  
      });  
	$scope.select=function(index){
		$scope.info=$scope.userInfos[index];
	};
	$scope.updateUser=function(info){
		$http({
			method:"post",
			url:"updateServlet",
			params:{userId:$scope.info.userId,userName:$scope.info.userName,userPwd:$scope.info.userPwd,userAge:$scope.info.userAge}
		}).success(function(data) {
			$scope.userInfos=data;
			location.reload();
      }).error(function(data,status,headers,config){
        alert("错误");  
      }); 
	};
	$scope.deleteUser=function(index){
		$http({
			method:"post",
			url:"deleteServlet",
			params:{userId:$scope.userInfos[index].userId}
		}).success(function(data) {
			$scope.userInfos=data;
			location.reload();
      }).error(function(data,status,headers,config){
        alert("错误");  
      }); 
	};
	$scope.addUser=function(info){
		$http({
			method:"post",
			url:"addServlet",
			params:{userId:$scope.info.userId,userName:$scope.info.userName,userPwd:$scope.info.userPwd,userAge:$scope.info.userAge}
		}).success(function(data) {
			$scope.userInfos=data;
			location.reload();
      }).error(function(data,status,headers,config){
        alert("错误");  
      }); 
	};
});
