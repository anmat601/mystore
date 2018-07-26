app.controller("kysMainController",function($scope,$http)
		{
	      $scope.showAllItems=function()
	       {
		     $http.post("http://localhost:8080/MyStoreWeb/rest/getAllItems")
	    	 .then(function(response)
	    			{
		            	{
		            		$scope.items = response.data;
		            	}
	             	}
	           );
	       }
	      $scope.myFunction=function()
	      {
	    	  $scope.add=1;
	      }
	      
         $scope.addItem=function()
          {
        	var itemData={};
        	$http.post("http://localhost:8080/MyStoreWeb/rest/addItem",$scope.itemData)
        	 .then(function(response)
        			 {
        		      alert('Item added');
        			 }
        	 );
		
	     }
       }
     );