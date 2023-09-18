package sdu.halal.halalchecker.presentation.home

import sdu.halal.halalchecker.presentation.data.ProductCategory
import sdu.halal.halalchecker.R
import sdu.halal.halalchecker.presentation.data.Additivies

class CategoryRepository{

    fun getData() : ArrayList<ProductCategory>{
        val listCategory = ArrayList<ProductCategory>()
        val category1 = ProductCategory("Milk",5,R.drawable.category_milk_image)
        val category2 = ProductCategory("Oil",8,R.drawable.category_oil_image)
        val category4 = ProductCategory("Bread",10,R.drawable.category_bread_image)
        val category3 = ProductCategory("Cheese",6,R.drawable.category_cheese_image)
        val category5 = ProductCategory("Meat",7,R.drawable.category_milk_image)

        listCategory.add(category1)
        listCategory.add(category2)
        listCategory.add(category3)
        listCategory.add(category4)
        listCategory.add(category5)

        return listCategory
    }

    fun getAdditiviesData() : ArrayList<Additivies>{
        val additiviesList = ArrayList<Additivies>()
        val additive1 = Additivies("107",R.drawable.additivies_tem_background)
        val additive2 = Additivies("201",R.drawable.additivies_tem_background_red)
        val additive3 = Additivies("103",R.drawable.additivies_tem_background_yellow)
        val additive4 = Additivies("105",R.drawable.additivies_tem_background)
        val additive5 = Additivies("105",R.drawable.additivies_tem_background)
        val additive6 = Additivies("103",R.drawable.additivies_tem_background_yellow)
        val additive7 = Additivies("201",R.drawable.additivies_tem_background_red)
        val additive8 = Additivies("201",R.drawable.additivies_tem_background_red)



        additiviesList.add(additive1)
        additiviesList.add(additive2)
        additiviesList.add(additive3)
        additiviesList.add(additive4)
        additiviesList.add(additive5)
        additiviesList.add(additive6)
        additiviesList.add(additive7)
        additiviesList.add(additive8)

        return additiviesList
    }
}

