package com.example.uidemo.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.example.uidemo.model.*
import java.io.IOException
import java.io.InputStream


class FakeData {

    fun fakeCategories(context: Context , dir_name : String) : ArrayList<CategoryModel>{
        val category : ArrayList<CategoryModel> = arrayListOf()

        val list: Array<String>
        try {
            list = context.assets.list(dir_name) as Array<String>
            if (list.isNotEmpty()) {
                for (fileName in list) {
                    val istr: InputStream = context.assets.open("$dir_name/$fileName")
                    val bitmap = BitmapFactory.decodeStream(istr)
                    category.add(CategoryModel(fileName.split(".")[0],bitmap))
                }
            }
        } catch (e: IOException) {
            Log.i("assets",e.toString())
        }
        return category
    }

    fun fakeItems(context: Context , dir_name : String) : ArrayList<ItemsModel>{
        var items : ArrayList<ItemsModel> = arrayListOf()

        val list: Array<String>
        try {
            list = context.assets.list(dir_name) as Array<String>
            if (list.isNotEmpty()) {
                for (fileName in list) {
                    val istr: InputStream = context.assets.open("$dir_name/$fileName")
                    val bitmap = BitmapFactory.decodeStream(istr)
                    items.add(ItemsModel(fileName.split(".")[0],bitmap,null,2520))
                }
            }
        } catch (e: IOException) {
            Log.i("assets",e.toString())
        }
        return items
    }

    fun fakeRequestForReturn(context: Context , dir_name : String) : ArrayList<ItemsModel>{
        var items : ArrayList<ItemsModel> = arrayListOf()

        val list: Array<String>
        try {
            list = context.assets.list(dir_name) as Array<String>
            if (list.isNotEmpty()) {
                for (fileName in list) {
                    val istr: InputStream = context.assets.open("$dir_name/$fileName")
                    val bitmap = BitmapFactory.decodeStream(istr)
                    items.add(ItemsModel(fileName.split(".")[0],bitmap, ReturnParam("00006432662","Refund",15355,"Complete",1)))
                }
            }
        } catch (e: IOException) {
            Log.i("assets",e.toString())
        }
        return items
    }

    fun fakeReturnItemsInformation(context: Context): ArrayList<ItemsModel> {
        return fakeItems(context,"Computers and Accessory")
    }

    fun fakeReturns(context: Context): ArrayList<MyReturnItemModel> {
        return arrayListOf<MyReturnItemModel>(
            MyReturnItemModel(10023649,
                "01/11/2014",
                "00006432662",
                15990,
                "Placeberg",
                fakeRequestForReturn(context,"Computers and Accessory"),
                "Processing","celeste_wright@gmail.com",
                AddressCardModel("Alternate Shipping Address","celeste wright","celeste_wright@gmail.com","36/4, Abdullah Bin Mohamed, Zone 14","1120,Doha,Qatar","+974 4499 5900")
            ),
            MyReturnItemModel(10023649,
                "01/11/2014",
                "00006432662",
                15990,
                "Placeberg",
                fakeRequestForReturn(context,"Computers and Accessory"),
                "Complete",
                "celeste_wright@gmail.com",
                AddressCardModel("Alternate Shipping Address","celeste wright","celeste_wright@gmail.com","36/4, Abdullah Bin Mohamed, Zone 14","1120,Doha,Qatar","+974 4499 5900")
            )
        )
    }

    companion object{


        val data : ArrayList<WishListItemModel> = arrayListOf(
            WishListItemModel("samsung galaxy watch 46mm (new edition)","20 qar",23,null,null,false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"EXCLUSIVE",true,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"PRE-ORDER",false,25000,4,"07:12:33")
        )

        val wishListParentItems = arrayListOf(
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"25% off",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"NEW",true,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"OFFER",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"PRE-ORDER",false,25000,4,"07:12:33")
        )

        val recentListParentItems = arrayListOf(
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,null,false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,null,false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"🎁",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"EXCLUSIVE",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"25% off",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"NEW",true,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"OFFER",false,25000,4,"07:12:33"),
            WishListItemModel("samsung galaxy watch 46mm (new edition)","1959 qar",23,null,"PRE-ORDER",false,25000,4,"07:12:33")
        )

        val pastNotificationData : ArrayList<PastNotificationModel> = arrayListOf(
            PastNotificationModel("1st","1st Notification"),
            PastNotificationModel("2nd","2nd Notification"),
            PastNotificationModel("3rd","3rd Notification"),
            PastNotificationModel("4th","4th Notification")
        )

        var cards : ArrayList<DebitCardModel> = arrayListOf(
            DebitCardModel("5454 5412 8552 5856" , "dfdfdg" , "12/2/2022","684"),
            DebitCardModel("8484 5623 8563 5233" , "dfdfdg" , "12/2/2022","684"),
            DebitCardModel("9652 6333 5526 5853" , "dfdfdg" , "12/2/2022","684")
        )

        var transactions : ArrayList<TransactionModel> = arrayListOf(
            TransactionModel("358056182",-500,3,2520,2251,"1 Jan 2020","10:29"),
            TransactionModel("358056182",+500,3,2520,2251,"1 Jan 2020","10:29"),
            TransactionModel("358056182",-500,3,2520,2251,"1 Jan 2020","10:29")
        )

        var tickets : ArrayList<TicketModel> = arrayListOf(
            TicketModel(null,2,55,"#123456789","ProductCon London : The Product Management Conference","02 Dec 2019","02 Feb 2019","3 PM" ,"7 PM",false),
            TicketModel(null,2,55,"#123456789","ProductCon London : The Product Management Conference","02 Dec 2019","02 Feb 2019","3 PM" ,"7 PM",false),
            TicketModel(null,2,55,"#123456789","ProductCon London : The Product Management Conference","02 Dec 2019","02 Feb 2019","3 PM" ,"7 PM",true)
        )

        var askReviewlIST : ArrayList<ReviewModel> = arrayListOf(
            ReviewModel(null,"Apple Galaxy Watches 46mm (New)",25,1,2.5F,"very good",false,"1/1/2022"),
            ReviewModel(null,"Apple Galaxy Watches 46mm (New)",25,2,2.5F,null,true,"1/1/2022"),
            ReviewModel(null,"Apple Galaxy Watches 46mm (New)",25,1,null,null,null,"1/1/2022")
        )

        var defaultAddress : ArrayList<AddressCardModel> = arrayListOf(
            AddressCardModel("Default Shipping Address","celeste wright","celeste_wright@gmail.com","36/4, Abdullah Bin Mohamed, Zone 14","1120,Doha,Qatar","+974 4499 5900"),
            AddressCardModel("Default Billing Address","celeste wright","celeste_wright@gmail.com","36/4, Abdullah Bin Mohamed, Zone 14","1120,Doha,Qatar","+974 4499 5900")
        )

        var alternateAddress : ArrayList<AddressCardModel> = arrayListOf(
            AddressCardModel("Alternate Shipping Address","celeste wright","celeste_wright@gmail.com","36/4, Abdullah Bin Mohamed, Zone 14","1120,Doha,Qatar","+974 4499 5900")
        )

        var zoneNumber = arrayOf("52 Al Khisa","52 Al Khisa","52 Al Khisa","52 Al Khisa","52 Al Khisa")

        var country = arrayOf("india", "qatar","usa", "uk","japan")

        var serviceItems : ArrayList<ServiceItemModel> = arrayListOf(
            ServiceItemModel(null,"Samsung Galaxy S10 (new color -space gray ); anther new color","1 jan 2020 10:29","Under Maintenance",null,null),
            ServiceItemModel(null,"Samsung Galaxy S10 (new color -space gray ); anther new color","1 jan 2020 10:29","Under Maintenance","january 15, 2020",
                arrayListOf(
                    ServiceItemUpdates("11:11","Your order has successfully verified"),
                    ServiceItemUpdates("11:11","Your order has successfully verified")
                )
            ),
            ServiceItemModel(null,"Samsung Galaxy S10 (new color -space gray ); anther new color","1 jan 2020 10:29","Under Maintenance",null)
        )

        var FakeUser = UserPersonalInfoModel("Celeste","Wright","celeste_wright@gmail.com","+974 3435 5456","10/10/1910")

        var FakeOrders = arrayListOf(
            MyOrderModel(
                358056182,
                "1 jan 2020 10:29",
                "Processing",
                arrayListOf(
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",false),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",true),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",false)
                ),
                "15 jan 2020 10:29",
                "Free",
                2820,
                -300,
                20,
                -20,
                -20,
                -20,
                2520,
                100,
                arrayListOf(
                    OrderUpdate("23:22","Alif:","Your order has been successfully verified"),
                    OrderUpdate("19:29","Alif:","Your order Received"),
                    OrderUpdate("18:02","Customer Name:","Your order has been successfully verified"),
                ),
                "15 jan 2020 10:29",
                DeliveryInfo("20400157513600","Al Wakrah - Doha","ibn Abdul Mutaib Street 21")
            ),
            MyOrderModel(
                358056182,
                "1 jan 2020 10:29",
                "Complete",
                arrayListOf(
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1)
                ),
                "15 jan 2020 10:29",
                "Free",
                2820,
                -300,
                20,
                -20,
                -20,
                -20,
                2520,
                100,
                arrayListOf(
                    OrderUpdate("23:22","Alif:","Your order has been successfully verified"),
                    OrderUpdate("19:29","Alif:","Your order Received"),
                    OrderUpdate("18:02","Customer Name:","Your order has been successfully verified"),
                ),
                "15 jan 2020 10:29",
                DeliveryInfo("20400157513600","Al Wakrah - Doha","ibn Abdul Mutaib Street 21")
            ),
            MyOrderModel(
                358056182,
                "1 jan 2020 10:29",
                "Cancelled",
                arrayListOf(
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",false),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",true),
                    MyOrderItemModel(null,"Samsung Galaxy Watch 46mm (new Edition)","Space Gray",1959,1,"15:22:22",false)
                ),
                "15 jan 2020 10:29",
                "Free",
                2820,
                -300,
                20,
                -20,
                -20,
                -20,
                2520,
                100,
                arrayListOf(
                    OrderUpdate("23:22","Alif:","Your order has been successfully verified"),
                    OrderUpdate("19:29","Alif:","Your order Received"),
                    OrderUpdate("18:02","Customer Name:","Your order has been successfully verified"),
                ),
                "15 jan 2020 10:29",
                DeliveryInfo("20400157513600","Al Wakrah - Doha","ibn Abdul Mutaib Street 21")
            )
        )

        var FakeDateAndTime = arrayListOf(
            "12 Jan 2019 to 31 Jan 2019",
            "12 Jan 2019 to 31 Jan 2019",
            "12 Jan 2019 to 31 Jan 2019",
            "12 Jan 2019 to 31 Jan 2019",
        )

        var fakeEvents = arrayListOf(
            EventAndActivitiesModel(
                null,
                "Amazing Climbing Wall",
                "2 jan 2020",
                "23 fab 2020",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                99,
                true,
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo . Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit , sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt . Neque porro quisquam est , qui dolorem ipsum quia dolor sit amet , consectetur .",
                arrayListOf(
                    EventSpeaker(null,"Dr. Ahmed Moamen","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore"),
                    EventSpeaker(null,"Dr. Samy Ahmed","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore")
                ),
                CustomerReviews(
                    4f,
                    42,
                    5,
                    3,
                    0,
                    1,
                    arrayListOf(
                        EventReview("Really Liteweight - i like it",4f,"A good laptop for the money . The screen is excellent , it doesn't make much noise , it doesn't get very hot , there is a button to turn on all the fans at once to the full , then it buy a cooling pad . makes noise , but I don't need it . In extreme cases , you can buy a cooling pad","Alex","01/04/2020")
                    )
                )
               ,
                "Alif Store, Doha, Qatar",
                "First Floor, Office 108, Building#B Gate 3,  Salwa Road,  Wolesale Market R/A, Doha, Qatar"
            ),
            EventAndActivitiesModel(
                null,
                "Amazing Climbing Wall",
                "2 jan 2020",
                "23 fab 2020",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                99,
                true,
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo . Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit , sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt . Neque porro quisquam est , qui dolorem ipsum quia dolor sit amet , consectetur .",
                arrayListOf(
                    EventSpeaker(null,"Dr. Ahmed Moamen","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore"),
                    EventSpeaker(null,"Dr. Samy Ahmed","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore")
                ),
                CustomerReviews(
                    4f,
                    42,
                    5,
                    3,
                    0,
                    1,
                    arrayListOf(
                        EventReview("Really Liteweight - i like it",4f,"A good laptop for the money . The screen is excellent , it doesn't make much noise , it doesn't get very hot , there is a button to turn on all the fans at once to the full , then it buy a cooling pad . makes noise , but I don't need it . In extreme cases , you can buy a cooling pad","Alex","01/04/2020")
                    )
                )
                ,
                "Alif Store, Doha, Qatar",
                null
            ),
            EventAndActivitiesModel(
                null,
                "Amazing Climbing Wall",
                "2 jan 2020",
                "23 fab 2020",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                99,
                true,
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo . Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit , sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt . Neque porro quisquam est , qui dolorem ipsum quia dolor sit amet , consectetur .",
                arrayListOf(
                    EventSpeaker(null,"Dr. Ahmed Moamen","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore"),
                    EventSpeaker(null,"Dr. Samy Ahmed","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium , totam rem aperiam , eaque ipsa quae ab illo inventore")
                ),
                null,
                "Alif Store, Doha, Qatar",
                "First Floor, Office 108, Building#B Gate 3,  Salwa Road,  Wolesale Market R/A, Doha, Qatar"
            ),

        )

        var fakeWrap = arrayListOf(
            WrapperModel(null,"New Year Wrap",10,true,"gray"),
            WrapperModel(null,"Gift wrap 1",6,null,"gray"),
            WrapperModel(null,"Gift wrap 2",null,null,"gray"),
            WrapperModel(null,"Gift wrap 3",null,null,"gray"),
        )
        var fakeCartItem = CartItemModel(
            null,
            "samsung galaxy watch 46mm (new edition)",
            "gray",
            WrapperModel(
                null,
                "New Year Wrap",
                10,
                true,
                "gray"
            ),
            arrayListOf(
                CartItemOption(
                    null,
                    "samsung galaxy watch 46mm (new edition)",
                    2520,
                    2000
                )
            ),
            false,
            1959
        )

        var fakeAddress = arrayListOf(
            CheckOutAddressModel("First Floor, Office 108, Building#B Gate 3,  Salwa Road,  Wolesale Market R/A, Doha, Qatar",59,true),
            CheckOutAddressModel("3/26 salva road, Zone 1, Doha, Qatar",27,false)
        )
    }
}