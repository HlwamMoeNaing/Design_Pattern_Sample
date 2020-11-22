package observer;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String message);
}

interface Publisher {
    void attach(Subscriber subscriber);

    void change(String message);
}
/*
 *..Publisher  == Subject
 * ..Subscriber == observer
 *ဒါကတော့ Subject သို.မဟုတ် Publisher interface ပါ။ Publisher ရဲ.တာဝန်က Subscriber သို.မဟုတ် Observer တွေကို လက်ခံရပါမယ်။
 *ဒါကြောင့် attach(Subscriber) ဆိုတာကိုရေးထားတာပါ။နောက် Publisher သည် data or state change လုပ်နိုင်ဖို.ပါရပါမယ်။
 * ဒါကို change အနေနဲ.ရေးထားပါတယ်။ နောက် class ကတော့ Subscriber ပါ။  ဒီနေရာမှာ publisher က deattach လဲလုပ်နိုင်ရမှာပါ။ ဒီမှာတော့ခနထားခဲ့ပါမယ်။
 */

class DataSource implements Publisher {
    List<Subscriber> subscriberList = new ArrayList<Subscriber>();


    @Override
    public void attach(Subscriber subscriber) {
        subscriberList.add(subscriber);

    }

    @Override
    public void change(String message) {
        System.out.println("Publisher Change " + message);
        for (Subscriber sub : subscriberList) {
            sub.update(message);
        }
    }
}
/*
* DataSource သည် Publisher ကို implement လုပ်ပါတယ်။ သူသည် Publisher ဖြစ်တဲ့အတွက် Observer or Subscriber တွေကလာ connect လုပ်မှာပါ။
* ဒါကြောင့် သူ.ထဲမှာ Subscriber တွေကိုသိမ်းဖို.ဒီလိုရေးထားပါတယ်။List<Subscriber> subscriberList = new ArrayList<Subscriber>();
* နောက် attach method မှာ ခုနက subscriberList ထဲကိုဒီလိုထဲ့ပေးလိုက်ရုံပါပဲ။
 subscriberList.add(subscriber);
 *
 * */
/*
*  နောက်အရေးကြီးတဲ့ method က change ပါ။ ဆိုပါစို. Publisher ,Subject ကပြောင်းပြီဆိုရင် ကျွန်တော်တို.က သူ.ကိုမှီခိုနေတဲ့ Observer or Subscriber တွေကို လှမ်း notify လုပ်ရပါမယ်။ ဒါကလွယ်ပါတယ်။ change method မှာဒီလိုရေးထားလိုက်ပါတယ်။
  for(Subscriber sub : subscriberList)
{
sub.update(message);
}
*  */
//သဘောကတော့ သူ.ကို subscribe or connect လုပ်ထားတဲ့ subscriber တွေကို သူchanges တခုခုဖြစ်သွားပြီဆိုတာကို လှမ်းအကြောင်းကြားတာပါ။
// ဒါဆို Observer , Subscriber တွေက သူတို. data ကိုသူတို.ပြန် ပြောင်းဒါမှမဟုတ် တခုခုလုပ်ရမှာပါ။ Subcriber or Observer ကိုဒီလိုရေးထားပါတယ်။

class View implements Subscriber {
    String viewName;

    public View(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void update(String message) {
        System.out.println("View " + viewName + " Update to " + message);
    }
}

//View ကတော့ Subscriber ကို implement လုပ်ထားတဲ့အတွက် update method ကို override လုပ်ပေးရမှာပါ။
//တကယ်လို. Subject or Publisher ကပြောင်း်တာနဲ. Subject or Publisher က View (Observer or Subscriber)ရဲ. update ကိုလှမ်းခေါ်မှာပါ။
//အဲ့မှာ View ကသူ.ဟာသူပြန် render လုပ်တာမျိုးလို.လုပ်ပေါ့။ခုကတော့ output ပဲထုတ်ပြထားတာပါ။ Demo ကတော့အောက်မှာပါ။


class ObserverDesignPattern {
    public static void main(String[] args) {
        Publisher dataSource = new DataSource();
        View view1 = new View("View1");
        View view2 = new View("View 2");
        View view3 = new View("View 3");
        dataSource.attach(view1);
        dataSource.attach(view2);
        dataSource.attach(view3);
        dataSource.change("Change1");
        dataSource.change("Chage 2");
    }
}
