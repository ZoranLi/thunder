package com.aplayer.aplayerandroid;

public class Constant {
    public static final String FRAGMENT_RGB = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 v_tex_coord_out;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_tex_coord_out);\n}";
    public static final String VERTEX = "precision mediump float;\nattribute vec4 a_position;\nuniform mat4 roat_x;\nattribute vec2 a_tex_coord_in;\nvarying vec2 v_tex_coord_out;\nvoid main() {\n    gl_Position  = a_position;\n    v_tex_coord_out = a_tex_coord_in;\n}";
    public static final String VERTEX2 = "precision mediump float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord_in;\nvarying vec2 v_tex_coord_out;\nvoid main() {\n    gl_Position  = a_position;\n    v_tex_coord_out = a_tex_coord_in;\n}";
}
