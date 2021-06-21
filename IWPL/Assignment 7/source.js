var app= angular.module("myApp",[]);
app.controller("myCtrl",function($scope){
    $scope.person={
        tax:10,
        invoice_number :1,
        customer_info:
        {
            name:"Amod Dhopavkar",
            web_link: 'xyz',
            address1: 'xyz',
            address2: 'xyz',
            postal: 'xyz'},
        company_info: {
            name: 'abc',
            web_link: 'abc',
            address1: 'abc',
            address2: 'abc',
            postal: 'abc'},

        payment_info: {
            email: 'amoddhopavkar2@gmail.com',
            Account_no: '00000'
            },

        country_currency :[
            {name: 'Canadian Dollar ($)',symbol: 'CAD $ '},
            {name: 'Euro (€)',symbol: 'Euro '},
            {name: 'Indian Rupee (₹)',symbol: 'Rs '},
            {name: 'Norwegian krone (kr)',symbol: 'kr '},
            {name: 'US Dollar ($)',symbol: '$'},
            {name: 'Aus Dollar ($)',symbol: ' Au $'}
        ],
        /*items:[
            { qty: 10, description: 'Mobile', cost: 300 }
        ],*/

        items:[],

    }
    $scope.today = new Date();
    $scope.addItem=function(){
        $scope.person.items.push([{
            description:"description",
            qty:1,
            cost:1

        }]);
    }
    $scope.removeItem = function(m){
        $scope.person.items.splice($scope.person.items.indexOf(m),1);
    }
    $scope.subTotal=function(){
        var total=0.0;
        angular.forEach($scope.person.items, function(item,key){
            total += item.qty*item.cost;
        });
        return total;
    };
    $scope.calcuteTax=function(){
        return (($scope.subTotal()*$scope.person.tax)/100);
    };
    $scope.grandTotal= function(){
        return ($scope.subTotal()+$scope.calcuteTax());

    };
});