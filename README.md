# Reciapp
La aplicación tiene lo siguiente:
- Tres actividades diferentes, la primera contiene un boton que te lleva al buscador de recetas, y un switch que te permite cambiar de temas entre el claro y el oscuro.
- Tiene PutExtra y GetExtra para pasar informacion entre actividades (desde la ListActivity a la DetailRecipeActivity, se pasa la Id y una string con la URL de la imagen)
- Tiene SharedPreferences, en el switch de la MainActivity donde guarda el tema claro/oscuro.
- Se utiliza la API Rest proporcionada para obtener las recetas y su información, en este caso se hace llamada con RetroFit2 en dos activities.
- Tiene un RecyclerView para poder visualizar las recetas obtenidas de la llamada al API
- La aplicación esta internacionalizada al ingles y al español.(Los campos que estan escritos a mano ya que el API es completamente en ingles)
- La aplicacioón hace uso del ViewBinding
