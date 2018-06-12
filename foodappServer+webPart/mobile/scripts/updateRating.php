<?php

require'db_con.php';



$rating= $_GET['rating']; 
$idlivreur= $_GET['idlivreur']; 



$sql="UPDATE livreur SET rating=".$rating." where idlivreur=".$idlivreur;


mysqli_query($link,$sql);
mysqli_close($link);

?>