<?php

require'db_con.php';



$idcommande= $_GET['idcommande']; 
$idlivreur= $_GET['idlivreur']; 
//$response;


$sql="UPDATE commande SET idlivreur=".$idlivreur.", etat='delivering' where idcommande=".$idcommande;

		//$response={'idcommande': $idcommande,'idlivreur': $idlivreur};

//echo json_encode($response);
mysqli_query($link,$sql);
mysqli_close($link);

?>