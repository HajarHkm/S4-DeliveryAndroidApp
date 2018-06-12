<?php

require'db_con.php';


$idlivreur= $_GET['idlivreur']; 
$tellivreur= $_GET['phoneNum']; 



$sql="UPDATE livreur SET tellivreur='".$tellivreur."' where idlivreur=".$idlivreur;


mysqli_query($link,$sql);
mysqli_close($link);

?>