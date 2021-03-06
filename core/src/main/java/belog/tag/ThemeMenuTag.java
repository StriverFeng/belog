package belog.tag;

import belog.plugin.TagPlugin;
import belog.pojo.PluginContent;
import belog.pojo.vo.ThemeVo;
import belog.service.PluginService;
import belog.service.ThemeService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.plaf.metal.MetalLookAndFeel.getCurrentTheme;

/**
 * 插件菜单
 * Created by Beldon
 */
@Service
public class ThemeMenuTag extends TagPlugin {

    @Autowired
    private PluginService pluginService;

    @Autowired
    private ThemeService themeService;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        ThemeVo themeVo = themeService.getCurrentTheme();
        List<String> themeMenus = new ArrayList<String>();
        if (themeVo != null && themeVo.getConfig() != null) {
            themeMenus.add("config");
        }
        env.setVariable("themeMenus", beansWrapper.wrap(themeMenus));
        body.render(env.getOut());
    }
}
