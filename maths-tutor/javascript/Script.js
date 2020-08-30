function changePic(){
   var radio = document.getElementsByName('gender');
   var formula = document.getElementsByName('Avator')
   if (radio[1].checked){
    changePic = "Avator.png";
   }
   if (radio[2].checked){
    changePic = "Avator_2.png";
   }
  
}