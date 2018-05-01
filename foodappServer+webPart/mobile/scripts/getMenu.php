<?php
require'db_con.php';
$search=$_GET['restau'];
$sql_menu="select * from plat where idrestau= (select idrestau from restau where nomrestau='".$search."')";

$menu=mysqli_query($link,$sql_menu);
$response=array();

if(mysqli_num_rows($menu) > 0)
{
	while($row=mysqli_fetch_array($menu))
	{
		array_push($response,array('idplat'=> $row['idplat'],'idrestau'=> $row['idrestau'],'nomplat'=>$row['nomplat'],'prixplat'=>$row['prixplat'],'categorieplat'=>$row['categorieplat'],
				'description'=>$row['description'],'imagepath'=>$row['imagepath']
			));
	}
}
echo json_encode($response);
mysqli_close($link);
?>
