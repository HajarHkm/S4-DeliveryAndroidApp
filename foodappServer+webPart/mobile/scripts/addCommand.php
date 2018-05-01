<?php

require'db_con.php';

$Body = file_get_contents('php://input');
$obj = json_decode($Body); 

$idclient= $obj->{'idclient'}; 
$idlivreur= $obj->{'idlivreur'}; 
$etat= $obj->{'etat'}; 




$sql="INSERT INTO commande (idclient,idlivreur,etat,datecommande) VALUES (".$idclient.", ".$idlivreur.", '".$etat."' , CURDATE())";
echo $sql;
mysqli_query($link,$sql);
mysqli_close($link);

?>