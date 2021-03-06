package belog.service;

import belog.pojo.vo.ConfigVo;
import belog.pojo.vo.ThemeVo;

import java.util.List;

/**
 * 主题模板管理Service
 * Created by Beldon
 */
public interface ThemeService {

    String DIRECTORY = "directory";
    String NAME = "name";
    String AUTHOR = "author";
    String URL = "url";
    String LOGO = "logo";
    String EMAIL = "email";
    String VERSION = "version";
    String DESCRIPTION = "description";
    String CONFIG_FILE = "theme.xml";


    /**
     * 获取模板路径
     *
     * @param template
     * @return
     */
    String getTemplatePath(String template);

    /**
     * 获取模板名称
     *
     * @return
     */
    String getThemeName();

    /**
     * 设置模板
     *
     * @param themeName 模板名称
     */
    void setTheme(String themeName);

    /**
     * 获取所有模板列表
     *
     * @return 模板列表
     */
    List<ThemeVo> getThemes();

    /**
     * 通过模板目录获取模板信息
     *
     * @param directory
     * @return
     */
    ThemeVo getThemeByDir(String directory);

    /**
     * 获取当前模板信息
     *
     * @return
     */
    ThemeVo getCurrentTheme();

    /**
     * @param key 获取配置值
     * @return
     */
    String getConfigValue(String key);

    /**
     * 新增或更新
     *
     * @param configVos
     */
    void saveOrUpdate(List<ConfigVo> configVos);

    /**
     * 获取主题配置类型
     *
     * @return
     */
    String getConfigType();

}
