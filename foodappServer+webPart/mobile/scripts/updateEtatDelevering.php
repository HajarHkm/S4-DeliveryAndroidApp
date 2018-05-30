<?php

require'db_con.php';

$Body = file_get_contents('php://input');
$obj = json_decode($Body); 

$idcommande= $obj->{'idcommande'}; 

$sql="UPDATE commande SET etat = "delviering" WHERE idcommande = '"$idcommande"' "
echo $sql;
mysqli_query($link,$sql);
mysqli_close($link);

?>