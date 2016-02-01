package com.moldfire.summoner.utility;

public class Formatting
{
	public static final String S = "§";
	public enum color{
		Black,
		DarkBlue,
		DarkGreen,
		DarkAqua,
		DarkRed,
		DarkPurple,
		Gold,
		Gray,
		DarkGrey,
		Blue,
		Green,
		Aqua,
		Red,
		LightPurple,
		Yellow,
		White,
		none
	}
	
	public enum formatting{
		Obfuscated,
		Bold,
		Strikethrough,
		Underline,
		Italic,
		Reset
	}
	
	public static String format(color c, formatting... f)
	{
		String buffer = "";
		switch(c)
		{
		case Black:
			buffer += S+"0";
			break;
		case DarkBlue:
			buffer += S+"1";
			break;
		case DarkGreen:
			buffer += S+"2";
			break;
		case DarkAqua:
			buffer += S+"3";
			break;
		case DarkRed:
			buffer += S+"4";
			break;
		case DarkPurple:
			buffer += S+"5";
			break;
		case Gold:
			buffer += S+"6";
			break;
		case Gray:
			buffer += S+"7";
			break;
		case DarkGrey:
			buffer += S+"8";
			break;
		case Blue:
			buffer += S+"9";
			break;
		case Green:
			buffer += S+"a";
			break;
		case Aqua:
			buffer += S+"b";
			break;
		case Red:
			buffer += S+"c";
			break;
		case LightPurple:
			buffer += S+"d";
			break;
		case Yellow:
			buffer += S+"e";
			break;
		case White:
			buffer += S+"f";
			break;
		default:
			break;
		}
		
		for(int i = 0; i < f.length; i++)
		{
			switch(f[i])
			{
			case Obfuscated:
				buffer += S+"k";
				break;
			case Bold:
				buffer += S+"l";
				break;
			case Strikethrough:
				buffer += S+"m";
				break;
			case Underline:
				buffer += S+"n";
				break;
			case Italic:
				buffer += S+"o";
				break;
			case Reset:
				buffer += S+"r";
				break;
			default:
				break;
			}
		}
		
		return buffer;
		
	}
}
