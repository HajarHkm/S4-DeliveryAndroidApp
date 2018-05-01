<?php

require'db_con.php';

$sql="select * from livreur where idlivreur != 1";

$results=mysqli_query($link,$sql);
$response=array();

if(mysqli_num_rows($results)>0)
{
	while($row=mysqli_fetch_array($results))
	{
		array_push($response,array('idlivreur'=> $row['idlivreur'],'nomlivreur'=> $row['nomlivreur'],'emaillivreur'=> $row['emaillivreur'],'tellivreur'=> $row['tellivreur'],'imagelivreur'=> $row['imagelivreur'])


		);
	}
}
                        
echo json_encode($response);
mysqli_close($link);
?>