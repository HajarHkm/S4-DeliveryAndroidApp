<?php

require'db_con.php';



$idcommande= $_GET['idcommande']; 
 
//$response;


$sql="UPDATE commande SET  etat='delivered' where idcommande=".$idcommande;

		//$response={'idcommande': $idcommande,'idlivreur': $idlivreur};

//echo json_encode($response);
mysqli_query($link,$sql);
mysqli_close($link);

?>