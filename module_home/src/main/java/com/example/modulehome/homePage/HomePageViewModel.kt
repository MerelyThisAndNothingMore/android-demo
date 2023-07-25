package com.example.modulehome.homePage

import androidx.lifecycle.MutableLiveData
import com.example.libbase.frame.mvvm.FrameBaseViewModel
import com.example.modulehome.recyclerview.CommonHolderData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * @author : zhangjin.rolling
 * @date : 星期三 2023/1/11
 */
@HiltViewModel
class HomePageViewModel @Inject constructor() : FrameBaseViewModel() {

    companion object {
        private const val TEXT_PATH =
            "/Users/wepalzhangjin/Desktop/Project/android-demo/module_home/src/poems.txt"

        private const val TEXT = "将进酒\n" +
                "李白\n" +
                "君不见黄河之水天上来，奔流到海不复回。\n" +
                "君不见高堂明镜悲白发，朝如青丝暮成雪。\n" +
                "人生得意须尽欢，莫使金樽空对月。\n" +
                "天生我材必有用，千金散尽还复来。\n" +
                "烹羊宰牛且为乐，会须一饮三百杯。\n" +
                "岑夫子，丹丘生，将进酒，杯莫停。【\n" +
                "与君歌一曲，请君为我倾耳听。\n" +
                "钟鼓馔玉不足贵，但愿长醉不复醒。\n" +
                "古来圣贤皆寂寞，惟有饮者留其名。\n" +
                "陈王昔时宴平乐，斗酒十千恣欢谑。\n" +
                "主人何为言少钱，径须沽取对君酌。\n" +
                "五花马、千金裘，呼儿将出换美酒，与尔同销万古愁。\n" +
                "#\n" +
                "侠客行\n" +
                "李白\n" +
                "赵客缦胡缨，吴钩霜雪明。\n" +
                "银鞍照白马，飒沓如流星。\n" +
                "十步杀一人，千里不留行。\n" +
                "事了拂衣去，深藏身与名。\n" +
                "闲过信陵饮，脱剑膝前横。\n" +
                "将炙啖朱亥，持觞劝侯嬴。\n" +
                "三杯吐然诺，五岳倒为轻。\n" +
                "眼花耳热后，意气素霓生。\n" +
                "救赵挥金槌，邯郸先震惊。\n" +
                "千秋二壮士，烜赫大梁城。\n" +
                "纵死侠骨香，不惭世上英。\n" +
                "谁能书阁下，白首太玄经。\n" +
                "#\n" +
                "白马篇\n" +
                "曹植\n" +
                "白马饰金羁，连翩西北驰。\n" +
                "借问谁家子，幽并游侠儿。\n" +
                "少小去乡邑，扬声沙漠垂。\n" +
                "宿昔秉良弓，楛矢何参差。\n" +
                "控弦破左的，右发摧月支。\n" +
                "仰手接飞猱，俯身散马蹄。\n" +
                "狡捷过猴猿，勇剽若豹螭。\n" +
                "边城多警急，虏骑数迁移。\n" +
                "羽檄从北来，厉马登高堤。\n" +
                "长驱蹈匈奴，左顾凌鲜卑。\n" +
                "弃身锋刃端，性命安可怀？\n" +
                "父母且不顾，何言子与妻！\n" +
                "名编壮士籍，不得中顾私。\n" +
                "捐躯赴国难，视死忽如归！\n" +
                "#\n" +
                "行行重行行\n" +
                "佚名\n" +
                "行行重行行，与君生别离。\n" +
                "相去万余里，各在天一涯。\n" +
                "道路阻且长，会面安可知？\n" +
                "胡马依北风，越鸟巢南枝。\n" +
                "相去日已远，衣带日已缓。\n" +
                "浮云蔽白日，游子不顾反。\n" +
                "思君令人老，岁月忽已晚。\n" +
                "弃捐勿复道，努力加餐饭。\n" +
                "#"

        private const val TAG = "HomePageViewModel"
    }

    val helloTitle = MutableLiveData<String>()

    val recyclerViewData = MutableLiveData<List<CommonHolderData>>()

    fun initData() {
        helloTitle.value = "Hello World!"

        recyclerViewData.value = genRecyclerViewData()
    }

    private fun genRecyclerViewData(): List<CommonHolderData> {
        val result: MutableList<CommonHolderData> = mutableListOf()

        val stringList = TEXT.lines()

        var title: String? = null
        var author: String? = null
        var content: MutableList<String> = mutableListOf()

        stringList.forEach {
            if (it.contains("#")) {
                result.add(
                    CommonHolderData(
                        title ?: "找不到标题", author ?: "佚名", content
                    )
                )
                title = null
                author = null
                content = mutableListOf()
            } else if (title == null) {
                title = it
            } else if (author == null) {
                author = it
            } else {
                content.add(it)
            }
        }

//        result.add(
//            CommonHolderData(
//                "ss",
//                "ss",
//                listOf("ss", "ss")
//            )
//        )

        return result;
    }
}